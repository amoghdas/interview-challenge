import { render, screen, cleanup } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";
import { describe, it, expect, afterEach } from "vitest";
import { Header } from "./Header";

afterEach(cleanup);

describe("Header", () => {
    it("should render the Ford Pro logo", () => {
        render(
            <MemoryRouter>
                <Header />
            </MemoryRouter>,
        );

        const logo = screen.getByAltText("Logo");
        expect(logo).toBeInTheDocument();
        expect(logo).toHaveClass("logo");
    });

    it("should render a navigation link to the fleet page", () => {
        render(
            <MemoryRouter>
                <Header />
            </MemoryRouter>,
        );

        const fleetLink = screen.getByRole("link", { name: /view fleet/i });
        expect(fleetLink).toBeInTheDocument();
        expect(fleetLink).toHaveAttribute("href", "/fleet");
    });

    it("should link the logo to the home page", () => {
        render(
            <MemoryRouter>
                <Header />
            </MemoryRouter>,
        );

        const logo = screen.getByAltText("Logo");
        expect(logo.closest("a")).toHaveAttribute("href", "/");
    });
});
