# ApiApp (NIT3213 Final Assignment)

This Android app, developed for the NIT3213 Mobile Application Development final assignment, uses Kotlin and Jetpack components. It allows users to log in using their first name and student ID, retrieve a list of cultural dishes from the "vu-nit3213-api", and view detailed information about each dish.

## Features

- Login screen with input validation
- Dashboard with scrollable list of dishes (RecyclerView)
- Detail screen with full description
- MVVM architecture with ViewModel and Repository
- REST API integration
- Clean Material Design UI

## Project Structure
```
com.example.assignmentlast/
├── data/
│   ├── api/
│   │   └── ApiService.kt
│   └── models/
│       ├── DashboardResponse.kt
│       ├── Entity.kt
│       └── LoginRequest.kt
│── repository/
│   └── MainRepository.kt
├── di/
│   └── AppModule.kt
├── ui/
│   ├── dashboard/
│   │   ├── DashboardActivity.kt
│   │   ├── DashboardViewModel.kt
│   │   └── EntityAdapter.kt
│   ├── details/
│   │   └── DetailsActivity.kt
│   └── login/
│       ├── LoginActivity.kt
│       └── LoginViewModel.kt
├── MainActivity.kt
└── MyApp.kt
```

## Build & Run Instructions

1. Clone this repository:
   ```bash
   git clone https://github.com/swayamsth/NIT3213-API.git
   ```

2. Open the project in Android Studio (Arctic Fox or later recommended)

3. Make sure you have the following installed:

   - Android SDK 21 or higher

   - Kotlin 1.9+

   - Java 21

   - Gradle 7.0+

4. Sync the project with Gradle files

5. Run the app on an emulator or physical device using: ▶️ Run > Run 'app'

## Dependencies
- Retrofit
- Gson
- Hilt (DI)
- Lifecycle ViewModel & LiveData
- Material Design 3
- JUnit4 + Mockito (unit tests)
- Kotlin Coroutines
- RecylerView & CardView

## Unit Testing

Unit Tests are located in:
```
app/src/test/java/com/example/apiapp/

```

## Author
- Name: Swayam Shrestha
- Student ID: s8105134
- Unit: NIT3213