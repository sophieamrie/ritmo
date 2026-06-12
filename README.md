# Ritmo — Your Daily Rhythm

Ritmo is a productivity and wellness Android app that helps you manage daily tasks, build habits, and stay informed about the weather — all wrapped in a beautiful illustrated scenery UI.

---

## Features

### Task Manager
- Add, complete, and delete daily tasks
- Tag tasks by category (Personal, Study, Health)
- Dynamic greeting based on time of day
- Empty state illustration when no tasks exist

### Habit Tracker
- Add habits with custom icons
- Daily check-in with streak tracking
- Weekly dot progress visualization
- Auto-reset at midnight

### Weather
- Live weather data from OpenWeatherMap API
- 5-day forecast
- Humidity, wind speed, and feels-like temperature
- Daily motivational quotes
- Offline support with cached data
- Refresh button when no internet connection

### Design
- Full-bleed illustrated scenery backgrounds (sunrise, dusk, coastal)
- Draggable floating bottom sheet panels
- Floating pill navigation bar
- Dark / Light theme toggle
- Custom app icon

---

## Technical Implementation

| Requirement | Implementation |
|---|---|
| 2+ Activities | `SplashActivity` navigates to `MainActivity` via Intent |
| Intent | Explicit Intent from Splash to Main |
| RecyclerView | Task list, Habit list, Forecast list |
| Fragment & Navigation | `TaskFragment`, `HabitFragment`, `WeatherFragment` + Navigation Component |
| Background Thread | `Handler` with `postDelayed` in `SplashActivity` |
| Networking | Retrofit + OpenWeatherMap API |
| Local Data Persistent | Room database for tasks and habits, SharedPreferences + Gson for weather cache |
| Dark/Light Theme | `AppCompatDelegate` + `drawable-night` resource variants |

---

## Architecture

```
MVVM Architecture
├── model/          — Task, Habit, HabitLog, WeatherResponse
├── data/
│   ├── local/      — Room database, DAOs, Repositories
│   └── remote/     — Retrofit, WeatherApiService
├── viewmodel/      — TaskViewModel, HabitViewModel, WeatherViewModel
└── ui/
    ├── task/       — TaskFragment, TaskAdapter, AddTaskDialog
    ├── habit/      — HabitFragment, HabitAdapter, AddHabitDialog
    └── weather/    — WeatherFragment, ForecastAdapter
```

---

## Getting Started

### Prerequisites
- Android Studio Panda (2025.3.1+)
- Android SDK 24+
- OpenWeatherMap API Key (free at [openweathermap.org](https://openweathermap.org))

### Setup
1. Clone the repository
   ```bash
   git clone https://github.com/YOUR_USERNAME/Ritmo.git
   ```
2. Open in Android Studio
3. Add your OpenWeatherMap API key in `WeatherFragment.kt`:
   ```kotlin
   private val apiKey = "YOUR_API_KEY_HERE"
   ```
4. Build and run on an Android device or emulator (API 24+)

---

## Dependencies

```toml
# Navigation
navigation-fragment
navigation-ui

# Networking
retrofit
retrofit-gson

# Database
room-runtime
room-ktx
ksp (annotation processor)

# Lifecycle
lifecycle-viewmodel
lifecycle-livedata

# Coroutines
coroutines-android

# UI
material
glide
```

---

## Design System

| Element | Value |
|---|---|
| Primary font | Nunito (800 weight) |
| Accent font | Lora (Serif, 600 weight) |
| Primary color | Peach #F2A58E |
| Sage green | #A8C5A0 |
| Lavender | #C5B8E8 |
| Sky blue | #89C4D8 |
| Background | Cream #FAF8F5 |

---

## Project Structure

```
app/
└── src/main/
    ├── java/com/example/ritmo/
    │   ├── data/
    │   │   ├── local/          — Room DB, DAO, Repository
    │   │   └── remote/         — Retrofit, API Service
    │   ├── model/              — Data classes
    │   ├── ui/                 — Fragments, Adapters, Dialogs
    │   ├── viewmodel/          — ViewModels
    │   ├── MainActivity.kt
    │   └── SplashActivity.kt
    └── res/
        ├── drawable/           — Vector assets, backgrounds
        ├── drawable-night/     — Dark mode variants
        ├── font/               — Nunito, Lora
        ├── layout/             — XML layouts
        ├── navigation/         — Nav graph
        └── values/             — Colors, themes, strings
```

---

## Developer

Built as a Final Lab Mobile 2026 assignment.

*Ritmo — find your daily rhythm.*
