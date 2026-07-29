# Take-Home Story

> As a Ford Pro fleet manager,
> I want to view all vehicles in my fleet,
> So that I can understand what's in my fleet at a glance.

Build this feature end-to-end: a backend API that serves vehicle data and a frontend page that displays it.

---

## What to Build

**Backend:** Create an API endpoint that returns all vehicles.

**Frontend:** Build a page that fetches vehicles from your API and displays them. Each vehicle has a **name**, **VIN**, and **availability** status.

How you structure this is up to you. Consider:

- Where should your API logic live? (controller, service, repository layers)
- How should you test it?
- What does a good API response look like for the frontend consumer?

---

## What's Already Here

The codebase has some foundation in place. Explore the project to understand what you're working with:

| Area | What's There |
|---|---|
| `backend/.../model/Vehicle.java` | JPA entity with fields: `id`, `name`, `vin`, `available` |
| `backend/.../repository/VehicleRepository.java` | Spring Data JPA repository |
| `backend/.../service/VehicleService.java` | Service class with repository injected |
| `backend/src/main/resources/data.sql` | Sample vehicle data |
| `frontend/src/components/fleet/Fleet.jsx` | Empty component shell |
| `frontend/src/test-utils/fleet-view-handlers.js` | MSW test handler. Shows the expected API response shape |

---

## Optional Enhancements

If you finish the core story and have time, consider these (not required but show depth):

- **Filter or search** vehicles by name or availability
- **Sort** the vehicle list by a column
- **Loading and error states** in the UI
- **Use a component library** (Material UI, etc.) or build your own components
- **Break the UI into smaller, reusable components**

---

## How to Work

1. **Write tests.** Show us your testing approach
2. **Commit often.** Small, meaningful commits that tell a story
