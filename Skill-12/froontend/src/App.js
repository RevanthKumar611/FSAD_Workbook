import React, { useEffect, useState } from "react";
import axios from "axios";
import AddStudent from "./components/AddStudent";
import StudentList from "./components/StudentList";
import "./App.css";

function App() {
  const [students, setStudents] = useState([]);
  const [selectedStudent, setSelectedStudent] = useState(null);

  const API_URL = "http://localhost:8080/students";

  // Fetch all students
  const fetchStudents = async () => {
    const response = await axios.get(API_URL);
    setStudents(response.data);
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  // Add or Update student
  const handleSubmit = async (student) => {
    if (student.id) {
      await axios.put(`${API_URL}/${student.id}`, student);
    } else {
      await axios.post(API_URL, student);
    }

    setSelectedStudent(null);
    fetchStudents();
  };

  // Delete student
  const handleDelete = async (id) => {
    await axios.delete(`${API_URL}/${id}`);
    fetchStudents();
  };

  // Edit student
  const handleEdit = (student) => {
    setSelectedStudent(student);
  };

  return (
    <div className="app">
      <h1>Student Management System</h1>

      <AddStudent
        onSubmit={handleSubmit}
        selectedStudent={selectedStudent}
      />

      <StudentList
        students={students}
        onDelete={handleDelete}
        onEdit={handleEdit}
      />
    </div>
  );
}

export default App;