/*
 * Sonar 1С Plugin
 * Copyright (C) 2017 Vasiliy Kazmin and SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar._1C.checks;

import com.sonar.sslr.squid.checks.CheckMessagesVerifier;
import org.junit.Test;
import org.sonar._1C.parser._1CAstScanner;
import org.sonar.squid.api.SourceFile;

import java.io.File;

import static org.hamcrest.Matchers.containsString;

public class ParsingErrorCheckTest {

    @Test
    public void test() {
        SourceFile file = _1CAstScanner.scanSingleFile(new File("src/test/resources/checks/parsingError.bsl"), new ParsingErrorCheck());
        CheckMessagesVerifier.verify(file.getCheckMessages())
                .next().atLine(3).withMessageThat(containsString("Parse error"))
                .noMore();
    }

}