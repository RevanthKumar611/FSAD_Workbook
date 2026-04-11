import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';

function Profile() {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    const userId = localStorage.getItem('userId');
    if (!userId) {
      navigate('/');  // redirect if not logged in
    } else {
      // Fetch full profile from backend
      axios.get(`http://localhost:8080/api/profile/${userId}`)
        .then(res => setUser(res.data))
        .catch(() => alert('Failed to load profile'));
    }
  }, [navigate]);

  const logout = () => {
    localStorage.clear();
    navigate('/');
  };

  return (
    <div className="container">
      <h2>My Profile</h2>
      <nav>
        <Link to="/home">Home</Link> |&nbsp;
        <Link to="/profile">Profile</Link> |&nbsp;
        <button onClick={logout}>Logout</button>
      </nav>
      {user ? (
        <div className="profile-card">
          <p><strong>ID       :</strong> {user.id}</p>
          <p><strong>Username :</strong> {user.username}</p>
          <p><strong>Email    :</strong> {user.email}</p>
        </div>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
}

export default Profile;