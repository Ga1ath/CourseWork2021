import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import Navbar from '../src/components/Navbar/Navbar';
import Home from '../src/components/Home/Home';
import Footer from './components/Footer/Footer';
import Auth from "./components/Auth/Auth";

function App() {
  return (
    <Router>
      <Navbar />
      <Switch>
      <Route exact path="/">
        <Home />
      </Route>
      <Route exact path="/auth">
        <Auth />
      </Route>
      </Switch>
        <Footer />
    </Router>

  );
}

export default App;
