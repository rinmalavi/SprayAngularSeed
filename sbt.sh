JVM_PARAMS="-Xss2m -Xms1g -Xmx1g -XX:+TieredCompilation -XX:ReservedCodeCacheSize=256m -XX:MaxPermSize=512m -XX:+CMSClassUnloadingEnabled -XX:+UseNUMA -XX:+UseParallelGC -Dscalac.patmat.analysisBudget=off"

GRUJ_PATH="./project/strap/gruj_vs_sbt-launch-0.13.x.jar"
RUN_CMD="java $JVM_PARAMS -jar $GRUJ_PATH $SBT_PARAMS"

eval "$RUN_CMD"
