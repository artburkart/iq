# coding=utf8

from Chapter1.Problem4.UrlSpaceEncoder import UrlSpaceEncoder as USE
from parameterizedtestcase import ParameterizedTestCase
import urllib


class UrlSpaceEncoder_Test(ParameterizedTestCase):
    test_list = [
        ("hello world  ", 11),
        ("", 0),
        ("   ", 1),
        ("a b c    ", 5),
        ("a b c do      ", 8),
        (" a b c do        ", 9)
    ]

    @ParameterizedTestCase.parameterize(("string", "true_length"), test_list)
    def test_url_space_encoder(self, string, true_length):
        self.assertEqual(
            USE.url_space_encoder(string, true_length),
            urllib.quote(string[:true_length]))

    def test_url_space_encoder_none_string_raises_error(self):
        self.assertRaises(AttributeError, USE.url_space_encoder, None, 0)

    def test_url_space_encoder_invalid_true_length_raises_error(self):
        self.assertRaises(AttributeError, USE.url_space_encoder, "aba b  ", -1)
