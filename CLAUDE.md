# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Repository purpose

A personal archive of Java (and some SQL) solutions to coding challenges from LeetCode, Project Euler, HackerRank, Advent of Code, and Amazon-style interview prep problems. There is no application, no build tool (no Maven/Gradle/Ant), and no test suite — this is a plain IntelliJ IDEA module of standalone, independent solution files.

## Build / run

- Project is a bare IntelliJ Java module (`Challenges.iml`), source root `src/`, compiled output to `out/`, targeting JDK 25 (see `.idea/misc.xml`).
- There is no build script. Compile/run individual files directly, e.g.:
  ```
  javac -d out src/com/slabodchikov/challenges/euler/Euler001.java
  java -cp out com.slabodchikov.challenges.euler.Euler001
  ```
- Many solutions (Euler, HackerRank, Advent of Code) are standalone programs with a `main` method that reads input via `Scanner` (from stdin or, for Advent of Code, a hardcoded local file path like `C:\Users\Roman\Documents\adventofcode\...\input.txt`). LeetCode/Amazon-style solutions are typically just a class with a public method (no `main`), matching the LeetCode submission format.
- No tests exist in the repo; do not assume a test framework is present.

## Structure

All code lives under `src/com/slabodchikov/challenges/`, split by challenge source:

- `leetcode/` — one class per problem, named `ProblemNNNN.java` matching the LeetCode problem number, containing the solution method(s) only (no `main`). Shared helper types like `ListNode.java` live alongside them.
- `euler/` — `EulerNNN.java` files (Project Euler), each with a `main` reading test-case input via `Scanner` plus the actual algorithm as a separate static method.
- `hackerrank/software/engineer/` — descriptively-named classes (e.g. `BSTHeight.java`, `BracketsValidator.java`) for HackerRank's software engineer track.
- `amazon/` — descriptively-named classes for Amazon-style interview questions (e.g. `GiftingGroups.java`, `TransactionLogs.java`).
- `adventofcode/y2022/dayN/` — one package per day, typically containing `Part1.java` and `Part2.java`, each with a `main` that reads a local input file.
- `sql/hackerrank/` — `.sql` solution files (not Java).

## Conventions to follow when adding new solutions

- Match the placement pattern above based on the challenge source (LeetCode number, Euler number, Advent of Code day/part, etc.) rather than inventing a new layout.
- LeetCode-style files: class named `ProblemNNNN` in `leetcode/`, with a Javadoc block like:
  ```java
  /**
   * @author Roman Slabodchikov
   * @see <a href="https://leetcode.com/problems/...">Problem</a>
   */
  ```
  and only the solution method(s) — no `main`.
- Euler/HackerRank/Advent-of-Code style files: include a `main` method, use `Scanner` for input, and keep the `@author Roman Slabodchikov` Javadoc tag consistent with existing files.
- Keep each solution self-contained; there's no shared utility library beyond a few small helpers (e.g. `SortingUtils.java`, `Anagram.java` at the top-level `challenges/` package).