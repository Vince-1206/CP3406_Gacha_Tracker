# CP3406 Gacha Tracker

A simple Android gacha pull simulator and tracker built using **Kotlin**, **Jetpack Compose**, and **Retrofit**.

---

## App Purpose

This project simulates a gacha system where users can pull characters, track pity counts, view pull history, and switch between different banner types. The app also loads character data from GitHub using a JSON API.

The purpose of this app is to practice Android development concepts including state management, API integration, and UI design.

---

## Features

* Pull 1 and Pull 10 system
* Pity system (guaranteed 5★ at 90 pulls)
* Multiple banner types:

  * Beginner Banner
  * Event Banner
  * Standard Banner
* Pull history tracking
* Character rarity system (3★, 4★, 5★)
* Character images support
* Settings page:

  * Change banner
  * Toggle character image display
  * High-rate demo mode
  * Reset pull history
* GitHub API integration for loading character data

---

## Screenshots

### Main Screen

(Add screenshot here)

### Settings Screen

(Add screenshot here)

---

## Project Structure

```text
app/
├── MainActivity.kt
├── GachaViewModel.kt
├── GachaRepository.kt
├── GachaApiService.kt
├── RetrofitInstance.kt
├── GachaCharacter.kt
```

### Architecture Pattern

This project uses a simple **MVVM architecture**:

* **Model** → GachaCharacter
* **ViewModel** → GachaViewModel
* **View** → MainActivity / Compose UI
* **Repository** → GachaRepository
* **API Layer** → Retrofit

---

## Pull Rate System

### Beginner Banner

| Rarity | Rate |
| ------ | ---- |
| 5★     | 3%   |
| 4★     | 15%  |
| 3★     | 82%  |

---

### Event Banner

| Rarity | Rate |
| ------ | ---- |
| 5★     | 5%   |
| 4★     | 20%  |
| 3★     | 75%  |

---

### Standard Banner

| Rarity | Rate |
| ------ | ---- |
| 5★     | 2%   |
| 4★     | 12%  |
| 3★     | 86%  |

---

### Pity System

After **90 pulls**, the next pull is guaranteed to be a **5★ character**.

---

## Technologies Used

* Kotlin
* Jetpack Compose
* Android ViewModel
* Material Design 3
* Retrofit
* Gson Converter
* Coil (for image loading)
* GitHub JSON API

---

## API Data Source

Character data is stored in:

`characters.json`

Loaded from GitHub:

https://github.com/Vince-1206/CP3406_Gacha_Tracker

This allows the app to update character data without changing the app code.

Example JSON:

```json
{
  "name": "Astra",
  "rarity": 5,
  "element": "Fire",
  "imageUrl": "https://example.com/astra.jpg"
}
```

---

## How to Run

1. Clone this repository:

```bash
git clone https://github.com/Vince-1206/CP3406_Gacha_Tracker.git
```

2. Open in Android Studio

3. Sync Gradle

4. Run emulator or physical device

5. Start pulling

---

## Future Improvements

* Add summon animation
* Add sound effects
* Add save/load local data
* Add limited-time event banners
* Add inventory system
* Add user login system
* Add duplicate reward conversion system

---

## Learning Reflection

Through this project, I learned:

* How to build UI using Jetpack Compose
* How to manage app state using ViewModel
* How to structure apps using MVVM
* How to integrate APIs with Retrofit
* How to use GitHub as a JSON backend
* How to use Coil for image loading
* How to improve UI with Material Design 3
* How Git commit and push workflow works

This project improved my understanding of Android app development and API integration.

---
