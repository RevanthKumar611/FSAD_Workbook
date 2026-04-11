import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';

function Login() {
  const [form, setForm] = useState({ username: '', password: '' });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async () => {
    try {
      const res = await axios.post('http://localhost:8080/api/login', form);
      // Save userId to localStorage
      localStorage.setItem('userId', res.data.id);
      localStorage.setItem('username', res.data.username);
      alert('Login Successful!');
      navigate('/home');
    } catch (err) {
      alert('Invalid Credentials!');
    }
  };

  return (
    <div className="container">
      <h2>Login</h2>
      <input name="username" placeholder="Username" onChange={handleChange} /><br/>
      <input name="password" placeholder="Password" type="password" onChange={handleChange} /><br/>
      <button onClick={handleSubmit}>Login</button>
      <p>No account? <Link to="/register">Register</Link></p>
    </div>
  );
}

export default Login;