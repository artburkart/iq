from setuptools import setup, find_packages
setup(
    name="iq",
    version="0.0.2",
    packages=find_packages(),

    # Project uses reStructuredText, so ensure that the docutils get
    # installed or upgraded on the target machine
    install_requires=[
        "argparse>=1.2.1",
        "nose>=1.3.4",
        "parameterizedtestcase>=0.1.0",
        "wsgiref>=0.1.2"
    ],

    include_package_data=True,

    author="Arthur Burkart",
    author_email="artburkart@gmail.com",
    description="Practice Coding Interviews",
    license="MIT",
    keywords="iq interview questions coding"
)
