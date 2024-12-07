# Spring Boot Application + Discord JDA

This project integrates JDA (Java Discord API) to manage interactions 
with Discord. It leverages Spring Boot to handle the lifecycle of the 
bot and related tasks, providing a clean architecture that utilizes 
Spring's dependency injection and other features.

## Setup

Define an environment variable `TEST_DISCORD_BOT` with your Discord token. 
This token is required for the bot to authenticate and connect to Discord.

## Dependency Versions Management

For the dependency versions management, see the `libs.versions.toml`
file located in the `./gradle/libs.versions.toml` directory. This file 
centralizes the versions of dependencies used across the project, 
helping to maintain consistency and avoid version conflicts.

## Build and Run

To build and run the application, execute the gradle task `bootRun`.
