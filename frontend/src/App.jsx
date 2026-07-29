import "./App.css";
import { useNavigate } from "react-router-dom";

function App() {
    const navigate = useNavigate();

    return (
        <div className="primary-content">
            <h1>Manage My Fleet</h1>
            <div className="card">
                <button onClick={() => navigate("/fleet")}>View Fleet</button>
            </div>
        </div>
    );
}

export default App;
