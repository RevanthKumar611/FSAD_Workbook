import React, { useEffect, useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';

function Home() {
  const [username, setUsername] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    // Check if user is logged in
    const user = localStorage.getItem('username');
    if (!user) {
      navigate('/');  // redirect to login if not logged in
    } else {
      setUsername(user);
    }
  }, [navigate]);

  const logout = () => {
    localStorage.clear();
    navigate('/');
  };

  return (
    <div className="container">
      <h2>Welcome, {username}!</h2>
      <nav>
        <Link to="/home">Home</Link> |&nbsp;
        <Link to="/profile">Profile</Link> |&nbsp;
        <button onClick={logout}>Logout</button>
      </nav>
      <p>You are successfully logged in.</p>
    </div>
  );
}

export default Home;