# examples/things.py

# Let's get this party started!
from wsgiref.simple_server import make_server

import falcon
import json


# Falcon follows the REST architectural style, meaning (among
# other things) that you think in terms of resources and state
# transitions, which map to HTTP verbs.

from profiling import RetrieveProfile
from recommendation import Recommendation


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
        profiles = RetrieveProfile().ExtractUsersData()
        for profile in profiles:
            profile.addTag()

        recommendations = Recommendation.RetrieveProfileAndCalculate(profiles)

        resp.content_type = falcon.MEDIA_JSON
        resp.body = '[{"message": "Hello world!"}]'
        #resp.body = json.dumps(recommendation.__dict__ for recommendation in recommendations)
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
