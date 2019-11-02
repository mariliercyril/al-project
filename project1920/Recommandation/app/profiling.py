import requests
import json


class Profile:
    def __init__(self, data):
        #self.__dict__ = json.loads(data)
        self.id = data["id"]
        self.age = data["age"]
        self.money = data["money"]
        self.tagList = []

    def addTag(self):
        if self.age > 18 & self.age <= 21:
            # TODO check condition
            self.tagList.append("MAJOR")
        if self.money > 10000:
            self.tagList.append("RICH")


class RetrieveProfile:
    def ExtractUsersData(self):
        url = 'http://account:8081/retrieveUsers'
        #url = 'http://localhost:8081/retrieveUsers'

        # params = {'profileId':id}
        # response = requests.get(url, params)
        response = requests.get(url)
        parsed_json = (json.loads(response.text))
        profiles = []

        for user in parsed_json:
            profile = Profile(user)
            profiles.append(profile)
        return profiles
