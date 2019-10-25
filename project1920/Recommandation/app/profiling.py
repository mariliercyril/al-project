import requests


class Profile:
    def __init__(self, idParam, ageParam, moneyParam):
        self.id = idParam
        self.age = ageParam
        self.money = moneyParam
        self.tagList = []

    def addTag(self):
        if self.age > 18:
            self.tagList.append("MAJOR")



class RetrieveProfile:
    def ExtractUsersData(self):
        url = 'http://account:8081/retrieveProfile'
        #params = {'profileId':id}
        #response = requests.get(url, params)
        response = requests.get(url)
        profiles = []
        print(response)
        print(response)
        print(response)

        for i in range (0,0):

            profile = Profile()
            profiles.append(profile)
        return profiles