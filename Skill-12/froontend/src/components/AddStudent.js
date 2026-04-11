import React, { useEffect, useState } from "react";

function AddStudent({ onSubmit, selectedStudent }) {
  const [student, setStudent] = useState({
    name: "",
    email: "",
    course: "",
  });

  useEffect(() => {
    if (selectedStudent) {
      setStudent(selectedStudent);
    }
  }, [selectedStudent]);

  const handleChange = (e) => {
    setStudent({
      ...student,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(student);

    setStudent({
      name: "",
      email: "",
      course: "",
    });
  };

  return (
    <div className="form-container">
      <h2>{student.id ? "Update Student" : "Add Student"}</h2>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"
          placeholder="Enter Name"
          value={student.name}
          onChange={handleChange}
          required
        />

        <input
          type="email"
          name="email"
          placeholder="Enter Email"
          value={student.email}
          onChange={handleChange}
          required
        />

        <input
          type="text"
          name="course"
          placeholder="Enter Course"
          value={student.course}
          onChange={handleChange}
          required
        />

        <button type="submit">
          {student.id ? "Update Student" : "Add Student"}
        </button>
      </form>
    </div>
  );
}

export default AddStudent;