import "./header.css";
import logo from "../../assets/ford_pro.jpg";
import { Link } from "react-router-dom";

export function Header() {
    return (
        <header className="header">
            <Link to="/">
                <img src={logo} alt="Logo" className="logo" />
            </Link>
            <nav>
                <Link to="/fleet" className="nav-link">
                    View Fleet
                </Link>
            </nav>
        </header>
    );
}
