import { http, HttpResponse } from "msw";

export const FleetViewHandlers = [
    http.get("http://localhost:8080/api/fleet/vehicles", async () => {
        const vehicleList = [
            {
                id: "550e8400-e29b-41d4-a716-446655440001",
                name: "2024 Ford Lightning",
                vin: "1FTFW1E80MFA00001",
                available: true,
            },
            {
                id: "550e8400-e29b-41d4-a716-446655440002",
                name: "2024 Ford Mustang",
                vin: "1FA6P8TH5L5100002",
                available: false,
            },
            {
                id: "550e8400-e29b-41d4-a716-446655440003",
                name: "2024 Ford Transit",
                vin: "1FTBW2CM0MKA00003",
                available: true,
            },
        ];

        return HttpResponse.json(vehicleList, { status: 200 });
    }),
];
