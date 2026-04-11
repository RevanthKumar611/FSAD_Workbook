import React, { useEffect, useState } from "react";
import axios from "axios";
function App() {
const [message, setMessage] = useState("");
const [users, setUsers] = useState([]);
useEffect(() => {
axios.get("http://localhost:8080/api/message")
.then(res => setMessage(res.data));
axios.get("http://localhost:8080/api/users")
.then(res => setUsers(res.data));
}, []);
return (
<div>
<h1>Full Stack Deployment</h1>
<h2>{message}</h2>
<h3>Hello Welcome!!</h3>
<ul>
{users.map((user,index)=>(
<li key={index}>{user}</li>
))}
</ul>
</div>
);
}
export default App;