# Ford Pro Fleet Management — Candidate Instructions

Welcome to the Ford Pro technical interview! You'll be working on our Fleet Management application, a system that lets commercial customers manage their vehicles.

---

## Interview Format

| Phase | What | Duration |
|---|---|---|
| **Take-Home** | Build a full-stack feature | ~1 hour, on your own |
| **1-on-1 Session** | Code review, live pairing, and Q&A | ~1 hour, live |

The take-home portion asks you to build a feature end-to-end. During the 1-on-1, you will walk through your work, then pair with your interviewer on an add-on story that extends what you built.

### AI Policy

**AI tools are optional.** Use Copilot, ChatGPT, or whatever you'd normally use, or don't. We care about the result and that you understand your code. During the 1-on-1, we'll ask you to walk through your implementation and explain your decisions.

---

## Setup

1. Start the backend:
   ```bash
   cd backend
   ./gradlew --refresh-dependencies clean build
   ./gradlew bootRun
   ```
   Runs on `http://localhost:8080`. An H2 in-memory database is available with sample data pre-seeded in `data.sql`.

2. Start the frontend (in a new terminal):
   ```bash
   cd frontend
   npm install
   npm run dev
   ```
   Runs on `http://localhost:3000`.

3. Run tests:
   ```bash
   ./gradlew test            # Backend
   cd frontend && npm test   # Frontend
   ```

4. Format code before pushing:
   ```bash
   ./gradlew spotlessApply   # Backend
   npm run format             # Frontend
   ```

---
## Navigating the IDE
The toolbar icons on the far left of the editor open different panels. If you're not sure where the story or the project files are, start here:
| Icon | Panel | What it's for |
|---|---|---|
| 📄 | **Question Description** | The question/story description and instructions |
| 🗂️ | **Explorer** | Browse the full project file structure (backend + frontend) |
| 🔍 | **Search** | Search across all files in the project |
| 🔀 | **Source Control (Changes)** | View your changes, stage, and commit your work |
| ▶️ | **Run & Debug** | Launch and debug run configurations |
| 🧪 | **Testing** | Discover and run tests from the UI |
| 🐘 | **Gradle** | Browse and run Gradle tasks for the backend |
> 💡 Tip: Use **Question Description** or **Explorer** to find files, and the green **Run** and **Run Tests** buttons at the top-right to build, run, and test.

---
## Your Task

See [TAKE_HOME_STORY.md](TAKE_HOME_STORY.md) for the full story and requirements.

---

## What We're Evaluating

| What | What We Look For |
|---|---|
| **Trade-offs** | Are you making the right decisions for the story? |
| **TDD** | Tests alongside implementation, red -> green -> refactor |
| **Commit habits** | Small, incremental, descriptive messages |
| **Code understanding** | Can you explain every line of your code? |
| **Communication** | Think out loud, ask questions, discuss tradeoffs |
| **Customer thinking** | What does a good experience look like for the API consumer and end user? |
| **Framework knowledge** | Comfortable with Spring Boot and React patterns |

---

## FAQ

**What is the full interview timeline?**

1. **Take-Home** - You complete the coding assignment on your own (~1 hour).
2. **1-on-1 Session** - We meet live (~1 hour): 15 min reviewing your take-home, 30 min pairing on a new feature, and 15 min for your questions.
3. **Behavioral Interview** - If you haven't already had one, a behavioral interview will be scheduled as well.
4. **Decision** - You'll hear back from us within the next couple work days after your interviews are complete.

**Can I use AI tools?**

Yes. Ford is AI-forward and gives our teams access to a wide range of AI tools, so use whatever helps you do your best work. During the 1-on-1, we'll ask you to walk through your code, so make sure you understand everything you submit. Candidates who don't use AI won't be penalized.

**How long should the take-home take?**

About 1 hour. Don't over-engineer it. If you're spending significantly more time, step back and focus on the core requirements.

**What if I can't finish everything?**

Submit what you have. We'd rather see clean, well-committed, well-tested partial work than a rushed complete solution.

**What happens during the pairing portion?**

You'll be at the keyboard building a new feature while your interviewer acts as your pair. Think out loud, ask questions, and treat it like a normal pairing session. We care about *how* you work, not whether you finish.

**What tech stack is this?**

- **Backend:** Java 21 + Spring Boot + H2 in-memory database
- **Frontend:** React + Vite + Vitest + MSW

**I'm having trouble with the setup. Who do I contact?**

Make sure you've followed the setup instructions above carefully. Most issues are resolved by running the steps in order. If you're still stuck, reach out to your interviewer or recruiter. Don't spend your limited time debugging environment issues.

**Do I need to deploy anything?**

No. Everything runs locally.

---

Good luck!
