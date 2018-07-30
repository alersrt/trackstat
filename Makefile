###############################
# Common defaults/definitions #
###############################

comma := ,

# Checks two given strings for equality.
eq = $(if $(or $(1),$(2)),$(and $(findstring $(1),$(2)),\
                                $(findstring $(2),$(1))),1)




###########
# Aliases #
###########

build: maven.build

clean: maven.clean

# Resolve all project dependencies.
#
# Usage:
#	make deps

deps: maven.deps

docs: maven.docs

down: docker.down

up: docker.up




##################
# Maven commands #
##################

# Maven command.
#
# Usage:
#	make mvn [task=]
task ?=

maven:
	mkdir -p $(PWD)/.m2
	docker run \
		--rm \
		--name maven-worker \
		-u 1000 \
		-e MAVEN_CONFIG=/var/maven/.m2 \
		-v $(PWD)/.m2:/var/maven/.m2 \
		-v $(PWD):/usr/src/mymaven \
		-w /usr/src/mymaven \
		maven:alpine \
		mvn -Duser.home=/var/maven $(task)

# clean command
maven.clean:
	@make maven task='clean'

# deps command
maven.deps:
	@make maven task='dependency:go-offline'

# build command
maven.build:
	@make maven task='package'

# docs command
maven.docs:
	@make maven task='javadoc:javadoc'

# test command
maven.test:
	@make maven task='test jacoco:report'


###################
# Docker commands #
###################

# Stop project in Docker Compose development environment
# and remove all related containers.
#
# Usage:
#	make docker.down

docker.down:
	docker-compose down --rmi=local -v

# Run Docker Compose development environment.
#
# Usage:
#	make docker.up [rebuild=(yes|no)]
#	               [background=(no|yes)]

rebuild ?= yes
background ?= no

docker.up: docker.down
	docker-compose up \
		$(if $(call eq,$(rebuild),no),,--build) \
		$(if $(call eq,$(background),yes),-d,--abort-on-container-exit)




.PHONY: clean deps build docs up down \
		maven maven.clean maven.docs maven.build maven.deps maven.test \
		docker.up docker.down
