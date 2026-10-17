# Giftglow

Keep gift ideas before you forget. A focused, device-local consumer web app.

## What it does

Save a thoughtful idea as soon as it occurs to you.

## Run the web app

Host the contents of `web/` as the root of an HTTPS static site, or run a local static file server (for example, `python3 -m http.server 8080 --directory web`) and visit `http://localhost:8080/`. The app caches its own assets for subsequent offline visits. Do not open the HTML via `file://`.

## Android

`apk/gifts-debug.apk` is an **installable debug-signed APK**. It embeds the same web app; it does not need a network connection. To rebuild, install JDK 17, Android SDK Platform 35, Android Gradle Plugin dependencies, and Gradle 8.10.2; in `android/` run `gradle --no-daemon assembleDebug`. The build output is `android/app/build/outputs/apk/debug/app-debug.apk`. The binary in this repository is a debug build, **not a production-signed Play Store release**.

## Data and scope

Records stay on your device using browser/WebView storage. Use **Export my data** for a JSON backup. Clearing site or app data or uninstalling the app may erase saved records. No cloud sync, accounts, or push notifications. Deadlines only appear when the app is opened. This release has not passed on-device QA, accessibility/security audits, or store review.
