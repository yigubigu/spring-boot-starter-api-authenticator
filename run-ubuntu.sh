docker run --rm -i -v $(pwd):/work -e fileName=$file ubuntu bash -c  "/work/fix-pom.sh" 