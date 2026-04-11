import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';

function Register() {
  const [form, setForm] = useState({ username: '', email: '', password: '' });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async () => {
    try {
      await axios.post('http://localhost:8080/api/register', form);
      alert('Registered Successfully!');
      navigate('/');
    } catch (err) {
      alert('Registration Failed!');
    }
  };

  return (
    <div className="container">
      <h2>Register</h2>
      <input name="username" placeholder="Username" onChange={handleChange} /><br/>
      <input name="email"    placeholder="Email"    onChange={handleChange} /><br/>
      <input name="password" placeholder="Password" type="password" onChange={handleChange} /><br/>
      <button onClick={handleSubmit}>Register</button>
      <p>Already have account? <Link to="/">Login</Link></p>
    </div>
  );
}

export default Register;