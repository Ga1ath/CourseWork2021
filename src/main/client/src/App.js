import React from 'react';
import { BrowserRouter as Router, Route, Switch, useParams } from 'react-router-dom';

import Navbar from '../src/components/Navbar/Navbar';
import Home from '../src/components/Home/Home';
import Footer from './components/Footer/Footer';
import Auth from "./components/Auth/Auth";

import './index.css';
import Sessions from './components/Sessions/Sessions';
import Layout from "./components/Layout/Layout";
import Hall from "./components/Modals/Hall/Hall";
import BlurBg from "./components/BlurBG/BlurBG";
import { useSelector } from "react-redux";



const SessionsPage = () => {

  let { id } = useParams();
  return <Sessions filmId={id} />
}

function App() {
  let visible = useSelector(state => state.hallPopup.visible);

  return (
    <>
      {visible &&
        <>
          <BlurBg>

          </BlurBg>
          <Hall />
        </>
      }
      <Router>
        <div className="content">
          <Navbar />
          <Layout />
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
      </>
  );
}

export default App;
