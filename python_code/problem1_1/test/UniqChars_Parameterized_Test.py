# coding=utf8
from problem1_1.src.UniqChars import UniqChars
from parameterizedtestcase import ParameterizedTestCase


class UniqChars_Parameterized_Test(ParameterizedTestCase):
    @ParameterizedTestCase.parameterize(
        ("string", "method", "expected"),
        [
            ("", UniqChars.BIT, False),
            ("", UniqChars.BOOL, False),
            ("", UniqChars.SORTED, False),
            ("a", UniqChars.BIT, True),
            ("a", UniqChars.BOOL, True),
            ("a", UniqChars.SORTED, True),
            ("ab", UniqChars.BIT, True),
            ("ab", UniqChars.BOOL, True),
            ("ab", UniqChars.SORTED, True),
            ("aba", UniqChars.BIT, False),
            ("aba", UniqChars.BOOL, False),
            ("aba", UniqChars.SORTED, False),
            ("aaba", UniqChars.BIT, False),
            ("aaba", UniqChars.BOOL, False),
            ("aaba", UniqChars.SORTED, False),
            ("baa", UniqChars.BIT, False),
            ("baa", UniqChars.BOOL, False),
            ("baa", UniqChars.SORTED, False),
            ("abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.BIT, True),
            ("abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.BOOL, True),
            ("abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.SORTED, True),
            (("abcdefghijklmnopqrstuvwxyz{|}~_`"
                "abcdefghijklmnopqrstuvwxyz{|}~_`"), UniqChars.BIT, False),
            (("abcdefghijklmnopqrstuvwxyz{|}~_`"
                "abcdefghijklmnopqrstuvwxyz{|}~_`"), UniqChars.BOOL, False),
            (("abcdefghijklmnopqrstuvwxyz{|}~_`"
                "abcdefghijklmnopqrstuvwxyz{|}~_`"), UniqChars.SORTED, False),
            ("!🛅", UniqChars.BIT, True),
            ("!🛅", UniqChars.BOOL, True),
            ("!🛅", UniqChars.SORTED, True),
            ("!🛅🛅", UniqChars.BIT, False),
            ("!🛅🛅", UniqChars.BOOL, False),
            ("!🛅🛅", UniqChars.SORTED, False),
        ]
    )
    def test_uniqChars_method(self, string, method, expected):
        self.assertEqual(UniqChars.uniqChars(string, method), expected)
