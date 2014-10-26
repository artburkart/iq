# coding=utf8

from Chapter1.Problem2.ReverseString import ReverseString
from parameterizedtestcase import ParameterizedTestCase
import random
import string


class ReverseString_Test(ParameterizedTestCase):
    test_list = (''.join(random.choice(string.printable)
                 for _ in range(random.randint(0, 100)))
                 for _ in range(100))

    @ParameterizedTestCase.parameterize(("string",), ((t,) for t in test_list))
    def test_reverse_string_method(self, string):
        self.assertEqual(ReverseString.reverse_string(string), string[::-1])

    def test_reverse_string_on_empty(self):
        self.assertEqual(ReverseString.reverse_string(''), '')
