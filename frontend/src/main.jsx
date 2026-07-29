import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import "./index.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Header } from "./components/header/Header.jsx";
import { Fleet } from "./components/fleet/Fleet.jsx";

ReactDOM.createRoot(document.getElementById("root")).render(
    <React.StrictMode>
        <Router>
            <Header />
            <Routes>
                <Route path="/" element={<App />} />
                <Route path="/fleet" element={<Fleet />} />
            </Routes>
        </Router>
    </React.StrictMode>,
);
