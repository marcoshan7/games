package net.vidageek.games.auth
import org.scribe.builder.api.TwitterApi
import org.scribe.builder.api.Api
import org.scribe.builder.ServiceBuilder
import org.scribe.oauth.OAuthService
import net.vidageek.games.vraptor.OAuthSecrets

object OAuthServiceBuilder {
  
  val apis = Map("twitter" -> classOf[TwitterApi])
  
  def apply(provider: AuthProvider, secrets: OAuthSecrets) = {
    val authService = new ServiceBuilder().provider(apis(provider.name)).apiKey(secrets.apiKeyFor(provider.name))
     .apiSecret(secrets.apiSecretFor(provider.name)).callback("http://games.vidageek.net").build
    new OAuthServiceBuilder(authService)
  }
  
}

class OAuthServiceBuilder(authService: OAuthService) {
  
  val requestToken = authService.getRequestToken()
  
  val autorizationUrl = authService.getAuthorizationUrl(requestToken)
  
}