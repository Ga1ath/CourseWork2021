import React from 'react';
import { BrowserRouter as Router, Route, Switch, useParams } from 'react-router-dom';

import Navbar from '../src/components/Navbar/Navbar';
import Home from '../src/components/Home/Home';
import Footer from './components/Footer/Footer';
import Auth from "./components/Auth/Auth";

import './index.css';
import Sessions from './components/Sessions/Sessions';

const SessionsPage = () => {

  let { id } = useParams();
  return <Sessions filmId={id} />
}

function App() {
  return (
    <Router>
      <div className="content">
        <Navbar />

        <Switch>
          <Route exact path="/">
            <Home />
          </Route>
          <Route exact path="/auth">
            <Auth />
          </Route>
          <Route exact path="/sessions/:id">
            <SessionsPage />
          </Route>
        </Switch>
      </div>
      <Footer />
    </Router>
  );
}

export default App;
