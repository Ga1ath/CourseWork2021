import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import Navbar from '../src/components/Navbar/Navbar';
import Home from '../src/components/Home/Home';

function App() {
  return (
    <Router>
      <Navbar />
      <Switch>
      <Route exact path="/">
        <Home />
      </Route>
  </Switch>
    </Router>

  );
}

export default App;
