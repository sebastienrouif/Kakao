import org.kohsuke.github.GitHubBuilder

class Github(private val token: String) {
    private val github by lazy { GitHubBuilder().withOAuthToken(token).build() }
    private val kakaoRepo by lazy { github.getRepository("kakaocup/kakao") }

    val collaborators by lazy { kakaoRepo.collaborators }
}
