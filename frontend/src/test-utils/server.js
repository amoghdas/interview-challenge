import { setupServer } from "msw/node";
import { FleetViewHandlers } from "./fleet-view-handlers";

export const server = setupServer(...FleetViewHandlers);
