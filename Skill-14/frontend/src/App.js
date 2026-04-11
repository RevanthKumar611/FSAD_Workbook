import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Register from './components/Register';
import Login from './components/Login';
import Home from './components/Home';
import Profile from './components/Profile';
import './App.css';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/"         element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/home"     element={<Home />} />
        <Route path="/profile"  element={<Profile />} />
      </Routes>
    </Router>
  );
}

export default App;