# Tracks statistic

Simple test application.

## The main goal

Need to create a web application which allows the next operations:
1. Enter the data from json via web form (json is presented below).
2. Save data into datastore by click on a form's button.
3. Show saved data on the form the such way that we can to repeat the first step.

Requirements: embedded microcontainer (jetty, tomcat), postgres, maven, spring.

### JSON example

```json
{
	"tracks": [{
		"id": 1,
		"name": "Millbrook",
		"description": "Millbrook city course race track",
		"length": {
			"unit": "km",
			"value": 7.4
		},
		"cars": [{
			"id": "2",
			"code": "rdb1",
			"transmission": "automatic",
			"ai": "enabled",
			"max-speed": {
				"unit": "mps",
				"value": 110.12121212
			}
		}, {
			"id": "1",
			"code": "rdb3",
			"transmission": "automatic",
			"ai": "disabled",
			"max-speed": {
				"unit": "mps",
				"value": 120.967
			}
		}]
	}]
}
```

## The environment variables

### `TRACKSTAT_PORT`

Specifies port of this application. Default value is `8080`.

### `POSTGRES_URL`

Specifies URL of PostgreSQL database. Default value is `jdbc:postgresql://localhost:5432/testdb`.

### `POSTGRES_USERNAME`

Specifies username of PostgreSQL database user. Default value is `postgres`.

### `POSTGRES_PASSWORD`

Specifies user's password in PostgreSQL. Default value is `postgres`.

## The REST endpoints

### `POST <address>/api/tracks`

Body is json which is presented above.

### `GET <address>/api/tracks`

Returns all stored tracks.
