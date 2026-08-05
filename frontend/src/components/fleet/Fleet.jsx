import { useEffect, useState } from "react";
import axios from "axios";
import "./Fleet.css";

const VEHICLES_URL = "http://localhost:8080/api/fleet/vehicles";

export function Fleet() {
    const [vehicles, setVehicles] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        axios
            .get(VEHICLES_URL)
            .then((response) => setVehicles(response.data))
            .catch(() => setError("Unable to load your fleet. Please try again later."))
            .finally(() => setLoading(false));
    }, []);

    if (loading) {
        return (
            <div className="primary-content">
                <h1>View Fleet</h1>
                <p role="status">Loading your fleet...</p>
            </div>
        );
    }

    if (error) {
        return (
            <div className="primary-content">
                <h1>View Fleet</h1>
                <p role="alert" className="fleet-error">
                    {error}
                </p>
            </div>
        );
    }

    return (
        <div className="primary-content">
            <h1>View Fleet</h1>
            {vehicles.length === 0 ? (
                <p>No vehicles found.</p>
            ) : (
                <table className="fleet-table">
                    <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">VIN</th>
                            <th scope="col">Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        {vehicles.map((vehicle) => (
                            <tr key={vehicle.id}>
                                <td>{vehicle.name}</td>
                                <td className="fleet-vin">{vehicle.vin}</td>
                                <td>
                                    <span
                                        className={
                                            vehicle.available ? "fleet-status fleet-status-available" : "fleet-status fleet-status-unavailable"
                                        }
                                    >
                                        {vehicle.available ? "Available" : "Not Available"}
                                    </span>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>
    );
}
