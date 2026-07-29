import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";
import { describe, it, expect } from "vitest";
import App from "./App";

describe("App", () => {
    it("renders the homepage", () => {
        render(
            <MemoryRouter>
                <App />
            </MemoryRouter>,
        );

        expect(screen.getByText("Manage My Fleet")).toBeInTheDocument();
    });
});
