sbtResolver <<= (sbtResolver) { r =>
  Option(System.getenv("SBT_PROXY_REPO")) map { x =>
    Resolver.url("proxy repo for sbt", url(x))(Resolver.ivyStylePatterns)
  } getOrElse r
}

resolvers <<= (resolvers) { r =>
  (Option(System.getenv("SBT_PROXY_REPO")) map { url =>
    Seq("proxy-repo" at url)
  } getOrElse {
    r ++ Seq(
      "twitter.com" at "http://maven.twttr.com/",
      "scala-tools" at "https://oss.sonatype.org/content/groups/scala-tools/",
      "maven" at "http://repo1.maven.org/maven2/",
      "freemarker" at "http://freemarker.sourceforge.net/maven2/"
    )
  }) ++ Seq("local" at ("file:" + System.getProperty("user.home") + "/.m2/repo/"))
}

externalResolvers <<= (resolvers) map identity

libraryDependencies <+= (sbtVersion) { sv =>
  "org.scala-sbt" % "scripted-plugin" % "0.12.1"
}

//addSbtPlugin("com.twitter" % "sbt-package-dist" % "1.0.0", "0.11.2", "2.9.1")
