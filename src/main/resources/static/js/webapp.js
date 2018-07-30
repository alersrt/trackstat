const instanceAxios = axios.create({
  baseURL: '/api/',
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json'
  }
});

class Car extends React.Component {
  render() {
    return (
      <tr id={this.props.id} class="webapp">
        <td class="webapp">{this.props.code}</td>
        <td class="webapp">{this.props.transmission}</td>
        <td class="webapp">{this.props.ai}</td>
        <td
          class="webapp">{this.props['max-speed'].value} {this.props['max-speed'].unit}</td>
      </tr>
    );
  }
}

class Track extends React.Component {
  render() {
    return (
      <div id={this.props.id} class="webapp">
        <p><b>Name</b>: {this.props.name}</p>
        <p><b>Description</b>: {this.props.description}</p>
        <p><b>Length</b>: {this.props.length.value} {this.props.length.unit}</p>
        <table class="webapp">
          <tr class="webapp">
            <th class="webapp">Code</th>
            <th class="webapp">Transmission</th>
            <th class="webapp">AI</th>
            <th class="webapp">Max. speed</th>
          </tr>
          {this.props.cars.map(
            c => <Car id={c.id} code={c.code} transmission={c.transmission}
                      ai={c.ai} max-speed={c['max-speed']}/>)}
        </table>
      </div>
    );
  }
}

onLoad();

function onLoad() {
  instanceAxios.get('/tracks/').then(function (response) {
    let tracks = response.data;
    ReactDOM.render(
      <div>
        <div id="util-div">
          <button onClick={newTrack}>Add track</button>
        </div>
        <hr/>
        <div>
          {tracks.map(
            p => <Track id={p.id} name={p.name} description={p.description}
                        length={p.length} cars={p.cars}/>)}
        </div>
      </div>,
      document.getElementById('root'),
    );
  }).catch(function (error) {
    console.log(error);
  });
}

function newTrack() {
  ReactDOM.render(
    <div id="new-track">
      <p/><label htmlFor="track-json">Json:</label>
      <textarea id="track-json"></textarea>
      <p/>
      <button onClick={closeNewTrack}>Cancel</button>
      <button id="add-message" onClick={addTrack}>Submit</button>
    </div>,
    document.getElementById('util-div'),
  );
}

function closeNewTrack() {
  ReactDOM.render(
    <button onClick={newTrack}>Add track</button>,
    document.getElementById('util-div'),
  );
}

function addTrack() {
  instanceAxios.post('/tracks/', document.getElementById('track-json').value)
  .then(function () {
    closeNewTrack();
    onLoad();
  }).catch(function (error) {
    console.log(error);
  });
}
