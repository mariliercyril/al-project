class Recommendation:
    def __init__(self, profile, recommendation):
        self.profile = profile
        self.recommendations = recommendation

    @staticmethod
    def RetrieveProfileAndCalculate(profiles):
        recommendations = []
        for profile in profiles:
            if "MAJOR" in profile.tagList:
                print(profile.id + " has been recommended a major account")
                recommendations.append(Recommendation(profile, "major account"))
            if "RICH" in profile.tagList:
                print(profile.id + " has been recommended a new saving account")
                recommendations.append(Recommendation(profile, "new saving account"))
        return recommendations
