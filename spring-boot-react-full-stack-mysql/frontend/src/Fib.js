import React, { Component } from 'react';
import axios from 'axios';

class Fib extends Component {
  state = {
    seenIndexes: [],
    values: {},
    id: ''
  };

  componentDidMount() {
    this.fetchValues();
    this.fetchIndexes();
  }
 
  async fetchValues() {
    const values = await axios.get('http://localhost:8080/values/current');
    this.setState({ values: values.data });
  }

  async fetchIndexes() {
    const seenIndexes = await axios.get('http://localhost:8080/values/all');
    this.setState({
      seenIndexes: seenIndexes.data
    });
  }

  handleSubmit = async event => {
    

    await axios.post('http://localhost:8080/values', {
      id: this.state.id
    },{
        headers: {
          'Access-Control-Allow-Origin': true,
	  'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
        },
        });
    this.setState({ id: '' });
  };

  renderSeenIndexes() {
    return this.state.seenIndexes;
  }

  renderValues() {
    const entries = [];

    for (let key in this.state.values) {
      entries.push(
        <div key={key}>
          For index {key} I calculated {this.state.values[key]}
        </div>
      );
    }

    return entries;
  }

  render() {
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <label>Enter your index:</label>
          <input
            value={this.state.id}
            onChange={event => this.setState({ id: event.target.value })}
          />
          <button>Submit</button>
        </form>

        <h3>Indexes I have seen:</h3>
        {this.renderSeenIndexes()}

        <h3>Calculated Values:</h3>
        {this.renderValues()}
      </div>
    );
  }
}

export default Fib;
