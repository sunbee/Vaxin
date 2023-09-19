# Vaxin
Android App that reminds parents when vaccinations are due for their children.

![Vaxin Demo](https://github.com/sunbee/Vaxin/assets/5471571/f4bc8bdd-342d-4b29-848f-fd1d226f9e28)

## Why I built this app

Timely vaccinations are critical to a child's health!
But with 24 vaccinations in the first 18 months, parents need help!
Vaxin app keeps track so parents don't have to stress over it.
Just enter child's birthday and all set!

## What technologies have I applied

I have built the app as a native Android app in Kotlin with Jetpack Compose. It has features as follows:
1. Contemporary Model-View-View-Model (MVVM) architecture.
2. Responive UX with Jetpack Compose.
3. All app data stays local with Room DB.
4. Elevated aesthetics with themeing in Compose with Material 3.
5. Personalization: Include child's photo using the integrated Image Picker.
6. Detailed information about a vaccine in HTML view.
7. Birthdate selection with Calendar.

## How I went about it

- I have used vaccine information from the US Centers for Disease Control (CDC), including vaccine name, schedule and profile.
- I generate the vaccination schedule based off the child's birthdate. Implemented Data Picker using an external library.
- I have the Single Source of Truth for vaccine information in a plain text file with sample data. I cache it in Room DB.
- I have a Room DB as the Single Source of Truth for child's information. The schema has child-vaccine many-many relationship.
- I use Flow wrapped around List of items for holding DB records in the View Model. So any change to data in DB changes the UI state and UI is instantly updated.
- I use Material 3 theming in Compose for consistent colors throughout the UX.
- I have implemented the Image Picker to store the selected image locally for use in the app. So deleting the original image will not affect the app.
- And so on.
