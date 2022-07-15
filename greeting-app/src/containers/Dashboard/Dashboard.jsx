import { useState, useEffect } from "react";
import "./Dashboard.scss";
import GreetingList from "../../components/GreetingList/GreetingList";
import Form from "../../components/Form/Form";
import Home from "../Home/Home";

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Nav from "../../components/Nav/Nav";

const Dashboard = () => {
  const [greetings, setGreetings] = useState([]);

  const getGreetings = () => {}

  useEffect(() => {
    getGreetings();
  }, []);

  return (
    <Router>
      <Nav />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/greetings" element={<GreetingList greetings={greetings} />} />
        <Route path="/new-greeting" element={<Form />} />
      </Routes>
    </Router>
  )
}

export default Dashboard
