
FROM python:3.5-alpine

EXPOSE 80

# Install gunicorn
RUN pip install gunicorn==19.9.0

# Install falcon
RUN pip install falcon
RUN pip install requests
RUN pip install requests

# Add demo app
COPY ./app /app
WORKDIR /app

CMD ["gunicorn", "-b", "0.0.0.0:80", "main:app"]





#RUN pip3 install https://github.com/psf/requests/archive/master.zip
#RUN apk --no-cache add curl
ENV PYTHONUNBUFFERED 0

#EXPOSE 80
#COPY ./app /app
