# 🧑‍💻 Developer Readme – Android

This document contains guidelines and rules for developers contributing to the Android version of the UkaApp.

---

## 🚧 Rules for Collaborators

1. **Always create a pull request before merging to `main`.**  
2. **Never accept your own pull request.**  
3. **Never push directly to `main`.**  
4. **Always create an issue before creating a branch.**  
5. **Always write clear and consistent commit messages.**

---

## ✍️ Commit Message Guidelines

- Use **imperative mood**: “Add feature” og "Added feature", not “Adding feature”.
- Keep the summary **under 50 characters**.
- Start with a **capital letter**, and **omit the period** at the end. 
- Follow the format:
```
<type>: <short summary>
```

#### Examples
```
feat: add user login functionality
fix: correct null pointer in storage manager
docs: update README with setup instructions
refactor: simplify price calculation logic
test: add unit tests for event registration
```

## Accepted Commit Types
```
feat: Adds a new feature
fix: Fixes a bug
refactor: Changes code without altering functionality
docs: Updates documentation
style: Changes code formatting only (e.g. spaces, commas, indentation)
test: Adds or updates tests
chore: Maintenance tasks (e.g. dependencies, build, CI configuration)
```
---

## 🧷 Pull Requests

- Link the related issue in the description.  
- Provide a clear summary of changes.  
- Request **at least one reviewer**.  
- Ensure **all tests pass** before submitting.  
- Keep PRs **small and focused** on a single topic.  
- Do **not** merge without review approval.  

---
## 🧪 Run Tests

Run the tests via **Gradle** in the terminal (VS Code integrated terminal works great):




> Note: This developer documentation is under development.
