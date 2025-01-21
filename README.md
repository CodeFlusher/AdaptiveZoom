# AdaptiveZoom 1.8.9

Zoom mod for minecraft 1.8.9 with a highly customizable mouse sensitivity behaviour.

## Important info

This repository is created with a template [Forge1.8.9Template](https://github.com/nea89o/Forge1.8.9Template/tree/master?tab=readme-ov-file) which I'm very thankful for. Even though author explicitly said that back reference to the template is not necessary, but I'll leave a reference anyway.

Check

## Usage

This project uses [DevAuth](https://github.com/DJtheRedstoner/DevAuth) per default, so you can log in using your real
minecraft account. If you don't need that, you can remove it from the buildscript.

To run the mod you will need two JDKs, one Java 17 jdk and one Java 1.8 jdk. You can download those
from [here](https://adoptium.net/temurin/releases) (or use your own downloads).

When you import your project into IntelliJ, you need to set the gradle jvm to the Java 17 JDK in the gradle tab, and the
Project SDK to the Java 1.8 JDK. Then click on the sync button in IntelliJ, and it should create a run task
called `Minecraft Client`. If it doesn't then try relaunching your IntelliJ. **Warning for Mac users**: You might have to remove the `-XStartOnFirstThread` vm argument from your run configuration. In the future, that should be handled by the plugin, but for now you'll probably have to do that manually.

To export your project, run the `gradle build` task, and give other people the
file `build/libs/<modid>-<version>.jar`. Ignore the jars in the `build/badjars` folder. Those are intermediary jars that
are used by the build system but *do not work* in a normal forge installation.

If you don't want mixins (which allow for modifying vanilla code), then you can remove the references to mixins from
the `build.gradle.kts` at the lines specified with comments and the `com.example.mixin` package.

If you don't want access transformers (which allow for making methods public/non-final) you can delete the
`accesstransformer.cfg` file. If you make a change to the `accesstransformers.cfg` you might need to rebuild your
project using `./gradlew build --refresh-dependencies`.
