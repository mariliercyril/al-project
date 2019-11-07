class Recommendation:
    def RetrieveProfileAndCalculate(self, profiles):

        #getCatalog()

        for profile in profiles:
            if "MAJOR" in profile.tagList:
                print(profile.id + " has been recommended a major account")
            if "RICH" in profile.tagList:
                print(profile.id + " has been recommended a new saving account")

