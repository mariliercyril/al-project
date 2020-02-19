# examples/things.py

# Let's get this party started!
from wsgiref.simple_server import make_server

import falcon
import json
import requests


# Falcon follows the REST architectural style, meaning (among
# other things) that you think in terms of resources and state
# transitions, which map to HTTP verbs.

from profiling import RetrieveProfile
from recommendation import Recommendation
from simpleobj import Simple


class RequireJSON(object):
    def on_get(self, req, resp):
        if not req.client_accepts_json:
            raise falcon.HTTPNotAcceptable(
                'This API only supports responses encoded as JSON.',
                href='http://docs.examples.com/api/json')

        if req.method in ('POST', 'PUT'):
            if 'application/json' not in req.content_type:
                raise falcon.HTTPUnsupportedMediaType(
                    'This API only supports requests encoded as JSON.',
                    href='http://docs.examples.com/api/json')

        #id = req.get_param('id')
        #profiles = RetrieveProfile().ExtractUsersData()
        #for profile in profiles:
        #    profile.addTag()

        #recommendations = Recommendation.RetrieveProfileAndCalculate(profiles)

        #resp.content_type = falcon.MEDIA_JSON

        #simples = []
        #for recommendation in recommendations:
        #    simple = Simple(recommendation.profile.id, recommendation.recommendations)
        #    simples.append(simple)

        url = "https://8yibsgfqyb.execute-api.us-east-1.amazonaws.com/default/testConnectionMongoDB"
        payload = {}
        headers= {}
        response = requests.request("GET", url, headers=headers, data = payload)
        print(response.text.encode('utf8'))
        resp.body = response.text.encode('utf8')
        resp.status = falcon.HTTP_200


# falcon.API instances are callable WSGI apps
# in larger applications the app is created in a separate file
app = falcon.API()

# Resources are represented by long-lived class instances
things = RequireJSON()

# things will handle all requests to the '/things' URL path
app.add_route('/triggerRecommendation', things)

if __name__ == '__main__':
    with make_server('', 8000, app) as httpd:
        print('Serving on port 8000...')

        # Serve until process is killed
        httpd.serve_forever()
