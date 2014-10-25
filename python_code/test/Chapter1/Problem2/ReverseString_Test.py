# coding=utf8

from Chapter1.Problem2.ReverseString import ReverseString
from parameterizedtestcase import ParameterizedTestCase
import random
import string


class ReverseString_Test(ParameterizedTestCase):
    test_list = (''.join(random.choice(string.printable)
                 for _ in range(random.randint(0, 100)))
                 for _ in range(100))

    @ParameterizedTestCase.parameterize(
        ("string", "expected"), ((t, t[::-1]) for t in test_list))
    def test_reverse_string_method(self, string, expected):
        self.assertEqual(ReverseString.reverse_string(string), expected)

    def test_reverse_string_on_empty(self):
        self.assertEqual(ReverseString.reverse_string(''), '')
