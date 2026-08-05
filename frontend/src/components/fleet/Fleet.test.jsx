import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";
import { describe, it, expect, afterAll, afterEach, beforeAll } from "vitest";
import { http, HttpResponse } from "msw";
import { server } from "../../test-utils/server";
import { Fleet } from "./Fleet";

beforeAll(() => server.listen());
afterEach(() => server.resetHandlers());
afterAll(() => server.close());

describe("Fleet", () => {
    it("renders a loading message while fetching the fleet", async () => {
        server.use(
            http.get("http://localhost:8080/api/fleet/vehicles", async () => {
                await new Promise((resolve) => setTimeout(resolve, 50));
                return HttpResponse.json([]);
            }),
        );

        render(
            <MemoryRouter>
                <Fleet />
            </MemoryRouter>,
        );

        expect(screen.getByRole("status")).toHaveTextContent("Loading your fleet...");
    });

    it("displays the name, VIN, and availability status of every vehicle", async () => {
        render(
            <MemoryRouter>
                <Fleet />
            </MemoryRouter>,
        );

        expect(await screen.findByRole("table")).toBeInTheDocument();

        expect(screen.getByText("2024 Ford Lightning")).toBeInTheDocument();
        expect(screen.getByText("1FTFW1E80MFA00001")).toBeInTheDocument();
        expect(screen.getByText("2024 Ford Mustang")).toBeInTheDocument();
        expect(screen.getByText("1FA6P8TH5L5100002")).toBeInTheDocument();
        expect(screen.getByText("2024 Ford Transit")).toBeInTheDocument();
        expect(screen.getByText("1FTBW2CM0MKA00003")).toBeInTheDocument();

        expect(screen.getAllByText("Available")).toHaveLength(2);
        expect(screen.getAllByText("Not Available")).toHaveLength(1);
    });

    it("shows a friendly message when the fleet cannot be loaded", async () => {
        server.use(
            http.get("http://localhost:8080/api/fleet/vehicles", () => HttpResponse.json({ message: "Internal server error" }, { status: 500 })),
        );

        render(
            <MemoryRouter>
                <Fleet />
            </MemoryRouter>,
        );

        const alert = await screen.findByRole("alert");
        expect(alert).toHaveTextContent("Unable to load your fleet. Please try again later.");
    });

    it("shows an empty state when there are no vehicles", async () => {
        server.use(http.get("http://localhost:8080/api/fleet/vehicles", () => HttpResponse.json([])));

        render(
            <MemoryRouter>
                <Fleet />
            </MemoryRouter>,
        );

        expect(await screen.findByText("No vehicles found.")).toBeInTheDocument();
    });
});
